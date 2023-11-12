Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        g.Clear(Color.White)
        Dim x, y, c, n, i As Integer
        n = TextBox1.Text
        c = TextBox2.Text
        x = PictureBox1.Width / 2
        y = PictureBox1.Height / 2
        For i = 1 To n
            g.DrawLine(Pens.Black, x - c * (i - 1), y + c * (i - 1), x + c * i, y + c * (i - 1))
            g.DrawLine(Pens.Black, x + c * i, y + c * (i - 1), x + c * i, y - c * i)
            g.DrawLine(Pens.Black, x + c * i, y - c * i, x - c * i, y - c * i)
            g.DrawLine(Pens.Black, x - c * i, y - c * i, x - c * i, y + c * i)
        Next i
    End Sub
End Class
