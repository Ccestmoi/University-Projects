Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim km As Single
        km = TextBox1.Text
        Dim mile As Single
        mile = km / 1.852
        Label3.Text = mile & " miles"
    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        Label3.Text = ""
    End Sub
End Class
