Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
        Randomize()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        g.Clear(Color.White)
        ListBox1.Items.Clear()
        Dim n, r, x, y As Integer
        n = TextBox1.Text
        x = 10
        y = 300
        Dim t(n) As Integer
        For i = 0 To n - 1
            r = Int((20 * Rnd()) + 0)
            t(i) = r
            y = 400 - r * 10
            g.FillRectangle(Brushes.Black, x, y, 10, r * 10)
            ListBox1.Items.Add(r)
            x += 20
        Next
    End Sub
End Class
