Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim Ray As Single
        Ray = TextBox1.Text
        Dim Haut As Single
        Haut = TextBox2.Text
        Dim Vol As Single
        Vol = 3.14 / 3 * Ray ^ 2 * Haut
        TextBox3.Text = Format(Vol, "0.00")
    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        TextBox3.Text = ""
    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles TextBox2.TextChanged
        TextBox3.Text = ""
    End Sub
End Class
