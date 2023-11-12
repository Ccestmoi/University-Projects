Imports System.CodeDom

Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        g.Clear(Color.White)
        Dim x, y, c As Integer
        x = TextBox1.Text
        y = TextBox2.Text
        c = TextBox3.Text
        g.DrawLine(Pens.Black, x, y, x + c, y)
        g.DrawLine(Pens.Black, x + c, y - c, x + 2 * c, y - c)
        g.DrawLine(Pens.Black, x, y, x + c, y - c)
        g.DrawLine(Pens.Black, x + c, y, x + 2 * c, y - c)
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        g.Clear(Color.White)
        Dim x, y, c, n, i As Integer
        x = TextBox1.Text
        y = TextBox2.Text
        c = TextBox3.Text
        n = TextBox4.Text
        For i = 1 To n
            g.DrawLine(Pens.Black, x, y, x + c, y)
            g.DrawLine(Pens.Black, x + c, y - c, x + 2 * c, y - c)
            g.DrawLine(Pens.Black, x, y, x + c, y - c)
            g.DrawLine(Pens.Black, x + c, y, x + 2 * c, y - c)
            x += c
        Next i
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        g.Clear(Color.White)
        Dim x, y, c As Integer
        x = TextBox1.Text
        y = TextBox2.Text
        c = TextBox3.Text
        While c <> 0
            g.DrawLine(Pens.Black, x, y, x + c, y)
            g.DrawLine(Pens.Black, x + c, y - c, x + 2 * c, y - c)
            g.DrawLine(Pens.Black, x, y, x + c, y - c)
            g.DrawLine(Pens.Black, x + c, y, x + 2 * c, y - c)
            c = c / 2
            x += c
            y -= c * 0.5
        End While
    End Sub
End Class
