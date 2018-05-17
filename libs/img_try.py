import sys
from PIL import Image, ImageDraw

arguments = sys.argv[1:]
x=arguments[0]
y=arguments[1]
width=arguments[2]
height=arguments[3]

#im=Image.open('/home/ubuntu/motiondetector/resources/output.jpg')
im=Image.open('/tmp/third-eye/first-frame.jpg')
img1 = Image.new("RGB", im.size, (0,0,0))
draw = ImageDraw.Draw(img1)
#print im.size
draw.rectangle([(int(x),int(y)),(int(x)+int(width),int(y)+int(height))], fill="white")
#img1.save('/home/ubuntu/motiondetector/resources/mask.png',"PNG")
img2=img1.resize((640,360))
#img2.save('/home/ubuntu/motiondetector/resources/mask.png',"PNG")
img2.save('/tmp/mask.png',"PNG")
