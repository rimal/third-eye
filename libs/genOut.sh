x=`find ~/motion -regex '.*\.\(avi\)'`
combine=`echo $x | sed 's/ /\|/g'`
echo $combine
ffmpeg -y -i "concat:$combine" -c copy /tmp/third-eye/output.avi
ffmpeg -y -i /tmp/third-eye/output.avi -c:a aac -b:a 128k -c:v libx264 -crf 23 /tmp/third-eye/output.mp4