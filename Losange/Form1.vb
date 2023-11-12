Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim x, y, c, n As Integer
        x = TextBox1.Text
        y = TextBox2.Text
        c = TextBox3.Text
        n = TextBox4.Text
        g.Clear(Color.White)
        While n > 0
            g.DrawLine(Pens.Black, x, y - c, x + c, y)
            g.DrawLine(Pens.Black, x, y - c, x - c, y)
            g.DrawLine(Pens.Black, x - c, y, x, y + c)
            g.DrawLine(Pens.Black, x + c, y, x, y + c)
            x = x + c * 2
            n = n - 1
        End While
    End Sub
End Class
