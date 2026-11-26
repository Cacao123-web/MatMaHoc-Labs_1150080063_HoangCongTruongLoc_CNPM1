"""Bài 2.6 — AES-256-CBC và giao diện Tkinter."""
import argparse
import base64
import binascii
from pathlib import Path
import secrets
import tkinter as tk
from tkinter import filedialog, messagebox, ttk

from cryptography.hazmat.primitives import padding
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes


def to_base64(data):
    return base64.b64encode(data).decode("ascii")


def from_base64(text, label):
    try:
        return base64.b64decode(text.strip(), validate=True)
    except (ValueError, binascii.Error) as exc:
        raise ValueError(f"{label} phải là Base64 hợp lệ.") from exc


def new_key():
    return to_base64(secrets.token_bytes(32))


def new_iv():
    return to_base64(secrets.token_bytes(16))


def cbc(key_b64, iv_b64):
    key = from_base64(key_b64, "Key")
    iv = from_base64(iv_b64, "IV")
    if len(key) != 32 or len(iv) != 16:
        raise ValueError("Key phải đúng 32 byte và IV phải đúng 16 byte.")
    return Cipher(algorithms.AES(key), modes.CBC(iv))


def encrypt_text(plaintext, key_b64, iv_b64):
    encryptor = cbc(key_b64, iv_b64).encryptor()
    padder = padding.PKCS7(128).padder()
    data = padder.update(plaintext.encode("utf-8")) + padder.finalize()
    return to_base64(encryptor.update(data) + encryptor.finalize())


def decrypt_text(ciphertext, key_b64, iv_b64):
    decryptor = cbc(key_b64, iv_b64).decryptor()
    data = from_base64(ciphertext, "Ciphertext")
    if not data or len(data) % 16:
        raise ValueError("Độ dài bản mã CBC phải là bội số dương của 16 byte.")
    unpadder = padding.PKCS7(128).unpadder()
    padded = decryptor.update(data) + decryptor.finalize()
    try:
        return (unpadder.update(padded) + unpadder.finalize()).decode("utf-8")
    except (ValueError, UnicodeDecodeError) as exc:
        raise ValueError("Giải mã thất bại. Kiểm tra Key, IV và bản mã.") from exc


def parse_file(content):
    lines = content.strip().splitlines()
    if len(lines) != 2 or not lines[0].startswith("IV="):
        raise ValueError("Tệp phải có dòng IV=... và một dòng bản mã.")
    iv, ciphertext = lines[0][3:].strip(), lines[1].strip()
    data = from_base64(ciphertext, "Ciphertext")
    if len(from_base64(iv, "IV")) != 16 or not data or len(data) % 16:
        raise ValueError("IV hoặc độ dài bản mã trong tệp không hợp lệ.")
    return iv, ciphertext


class App(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("AES-CBC Python - LAB 2")
        self.resizable(False, False)
        frame = ttk.Frame(self, padding=14)
        frame.grid()
        ttk.Label(frame, text="BÀI NÂNG CAO 02 - AES-256-CBC (PYTHON)",
                  font=("Segoe UI", 14, "bold")).grid(
                      row=0, column=0, columnspan=3, sticky="w", pady=(0, 8))
        self.plain = self.text_area(frame, "Plaintext:", 1)
        self.key = self.field(frame, "Key", 2, new_key)
        self.iv = self.field(frame, "IV", 3, new_iv)
        self.cipher = self.text_area(frame, "Ciphertext:", 4)
        buttons = ttk.Frame(frame)
        buttons.grid(row=5, column=1, columnspan=2, sticky="w", pady=6)
        for label, handler in (("Encrypt", self.encrypt), ("Decrypt", self.decrypt),
                               ("Save File", self.save), ("Open File", self.open)):
            ttk.Button(buttons, text=label, command=handler).pack(side="left", padx=(0, 8))
        self.status = tk.StringVar(value="Bấm Generate Key và Generate IV trước.")
        ttk.Label(frame, textvariable=self.status, wraplength=540).grid(
            row=6, column=1, columnspan=2, sticky="w")

    def field(self, frame, label, row, generate):
        value = tk.StringVar()
        ttk.Label(frame, text=f"{label} (Base64):").grid(row=row, column=0, sticky="w")
        ttk.Entry(frame, textvariable=value, width=60).grid(row=row, column=1, pady=3)
        ttk.Button(frame, text=f"Generate {label}", command=lambda: value.set(generate())).grid(
            row=row, column=2, sticky="ew", padx=(8, 0))
        return value

    def text_area(self, frame, label, row):
        ttk.Label(frame, text=label).grid(row=row, column=0, sticky="nw", padx=(0, 8))
        widget = tk.Text(frame, width=64, height=5, wrap="char")
        widget.grid(row=row, column=1, columnspan=2, sticky="ew", pady=3)
        return widget

    @staticmethod
    def read(widget):
        return widget.get("1.0", "end-1c")

    @staticmethod
    def write(widget, text):
        widget.delete("1.0", "end")
        widget.insert("1.0", text)

    def encrypt(self):
        try:
            self.write(self.cipher, encrypt_text(self.read(self.plain), self.key.get(), self.iv.get()))
            self.status.set("Đã mã hóa AES-CBC.")
        except ValueError as exc:
            messagebox.showerror("Lỗi", str(exc), parent=self)

    def decrypt(self):
        try:
            self.write(self.plain, decrypt_text(self.read(self.cipher), self.key.get(), self.iv.get()))
            self.status.set("Đã giải mã AES-CBC.")
        except ValueError as exc:
            messagebox.showerror("Lỗi", str(exc), parent=self)

    def save(self):
        content = f"IV={self.iv.get().strip()}\n{self.read(self.cipher).strip()}\n"
        try:
            parse_file(content)
            path = filedialog.asksaveasfilename(parent=self, defaultextension=".txt",
                                                initialfile="aes_cbc_ciphertext.txt")
            if path:
                Path(path).write_text(content, encoding="utf-8")
                self.status.set(f"Đã lưu IV và bản mã vào {path}")
        except (ValueError, OSError) as exc:
            messagebox.showerror("Lỗi lưu tệp", str(exc), parent=self)

    def open(self):
        path = filedialog.askopenfilename(parent=self, filetypes=[("Text file", "*.txt")])
        if path:
            try:
                iv, ciphertext = parse_file(Path(path).read_text(encoding="utf-8-sig"))
                self.iv.set(iv)
                self.write(self.cipher, ciphertext)
                self.status.set("Đã khôi phục IV và bản mã. Nhập đúng Key rồi bấm Decrypt.")
            except (ValueError, OSError) as exc:
                messagebox.showerror("Lỗi mở tệp", str(exc), parent=self)


def self_test():
    for text in ("Xin chào AES-CBC", "", "1234567890123456", "Văn bản dài tiếng Việt có dấu. " * 200):
        key, iv = new_key(), new_iv()
        ciphertext = encrypt_text(text, key, iv)
        restored_iv, restored_ciphertext = parse_file(f"IV={iv}\n{ciphertext}\n")
        assert decrypt_text(restored_ciphertext, key, restored_iv) == text

    test_key = to_base64(bytes(32))
    test_iv = to_base64(bytes(16))
    ciphertext = encrypt_text("abc", test_key, test_iv)
    assert len(from_base64(ciphertext, "Ciphertext")) == 16
    try:
        decrypt_text(ciphertext, to_base64(bytes([1]) * 32), test_iv)
    except ValueError:
        pass
    else:
        raise AssertionError("Mẫu thử với khóa sai phải bị từ chối.")
    print("SELF-TEST OK: 4 round trips and wrong-key test passed.")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--self-test", action="store_true")
    if parser.parse_args().self_test:
        self_test()
    else:
        App().mainloop()
