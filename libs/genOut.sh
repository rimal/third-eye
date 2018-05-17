x=`find ~/motion -regex '.*\.\(avi\)'`
combine=`echo $x | sed 's/ /\|/g'`
echo $combine
ffmpeg -y -i "concat:$combine" -c copy /tmp/third-eye/output.avi
