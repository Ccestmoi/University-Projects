Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim HT As Single
        HT = TextBox1.Text
        Dim Art As Integer
        Art = TextBox2.Text
        Dim TTC As Single
        TTC = Art * HT * 1.2
        TextBox3.Text = Format(TTC, "0.00") & "€"
    End Sub

    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        TextBox3.Text = ""
    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles TextBox2.TextChanged
        TextBox3.Text = ""
    End Sub
End Class
