Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim n, c, x, y As Integer
        n = TextBox2.Text
        c = TextBox1.Text
        x = 10
        y = 10
        While n > 0
            g.DrawRectangle(Pens.Black, x, y, c, c)
            x = x + 2 * c
            n = n - 1
        End While
    End Sub
End Class
