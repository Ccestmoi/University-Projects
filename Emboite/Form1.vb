Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim x, y, c As Integer
        x = 10
        y = 10
        g.Clear(Color.White)
        c = TextBox1.Text
        While c >= 0
            g.DrawRectangle(Pens.Black, x, y, c, c)
            x = x + 10
            y = y + 10
            c = c - 20
        End While
    End Sub
End Class
