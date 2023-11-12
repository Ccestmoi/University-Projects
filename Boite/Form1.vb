Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim x, y, c As Integer
        g.Clear(Color.White)
        c = TextBox1.Text
        While c >= 1
            g.DrawRectangle(Pens.Black, 10, 10, c, c)
            c = c / 2
        End While
    End Sub
End Class
