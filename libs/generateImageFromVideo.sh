ffmpeg -y -i $1 -vf 'select=eq(n\,0)' -q:v 1 $2 
