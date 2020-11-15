import numpy as np
from PIL import Image
img1 = Image.open("one.jpg")
img2 = Image.open("two.jpg")
f = np.fft.fft2(img1)
magni = np.abs(f)
phase = np.angle(f)

print(magni,phase)