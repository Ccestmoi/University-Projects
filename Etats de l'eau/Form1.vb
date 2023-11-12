Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim temp As Single
        temp = TextBox1.Text
        If temp < 0 Then
            TextBox2.Text = "Glace"
        Else
            If temp > 100 Then
                TextBox2.Text = "Vapeur"
            Else
                TextBox2.Text = "Liquide"
            End If
        End If
    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        TextBox2.Text = ""
    End Sub
End Class
