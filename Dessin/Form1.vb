Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        g.FillEllipse(Brushes.Blue, 150, 150, 100, 100)
        g.FillEllipse(Brushes.Yellow, 175, 175, 50, 50)
        g.DrawLine(Pens.Black, 200, 150, 200, 250)
        g.DrawLine(Pens.Black, 150, 200, 250, 200)
    End Sub
End Class
