sub start(title)
	msgbox "hello",20,title
end sub

sub finish
	msgbox "goodbye"
end sub

call start(inputbox("hello"))
call finish