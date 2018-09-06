set tExcel = CreateObject("Excel.Application")

tExcel.Visible  = True
tExcel.workbooks.add
tExcel.sheets.add

tExcel.Cells(1,1).Value = "Monday"

tExcel.ActiveWorkbook.SaveAs "e:\rohan\excel.xls"
tExcel.Workbooks.close
tExcel.Application.quit