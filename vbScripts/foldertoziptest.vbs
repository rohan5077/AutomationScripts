Option Explicit  
   
Dim ObjArgs  
Set ObjArgs = Wscript.Arguments  
  
Zipper "C:\Users\rohans\Desktop\git_jenkins" , "C:\Users\rohans\Desktop\git_jenkins.zip"
    
    
  '  
  ' Zipping Function  
  '  
  Function Zipper(SrcF, DestF)  
    
     Dim fsys  
      set fsys = Wscript.CreateObject("Scripting.FileSystemObject")  
        
      IF Not (fsys.FolderExists(SrcF)) then  
          Wscript.echo " Source Folder Could not found..!! Please Check the path Again."  
          Exit Function  
      End IF   
        
      IF (fsys.FileExists(DestF)) then  
          Wscript.echo " Zip file Already Exists..!! Deleting it..?"  
          fsys.DeleteFile DestF  
          Wscript.echo " Zip file Deleted SuccessFully."  
      End IF   
    
      ' create an empty zip file  
      CreateObject("Scripting.FileSystemObject").CreateTextFile(DestF, True).Write "PK" & chr(5) & chr(6) & String(18, 0)  
        
      dim objshell, src, des  
        
      Set objshell = CreateObject("Shell.Application")  
      Set src = objshell.NameSpace(SrcF)  
      Set des = objshell.NameSpace(DestF)  
        
      des.CopyHere(src.Items)  
        
      Do Until des.Items.Count = src.Items.Count  
          Wscript.Sleep(200)  
      Loop  
    
      Wscript.echo "SuccessFully Zipped...!!!"      
            
      Set fsys = Nothing  
      Set objshell = Nothing  
      Set src = Nothing  
      Set des = Nothing  
    
  End Function   
  