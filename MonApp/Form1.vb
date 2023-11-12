Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim nom As String
        nom = TextBox1.Text
        Label2.Text = "Bonjour " & nom & "!"
    End Sub
End Class
