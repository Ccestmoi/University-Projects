Imports System.Xml

Public Class Form1
    Private g As Graphics
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        g = PictureBox1.CreateGraphics
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        g.Clear(Color.White)
        Dim x, y, n, i, cote As Integer
        n = TextBox1.Text
        cote = TextBox2.Text
        x = 10
        y = 10
        For i = 1 To n
            g.DrawRectangle(Pens.Black, x, y, cote, cote)
            x += cote
        Next i
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        g.Clear(Color.White)
        Dim x, y, n, i, j, cote As Integer
        n = TextBox1.Text
        cote = TextBox2.Text
        x = 10
        y = 10
        For j = 1 To n
            For i = 1 To n
                g.DrawRectangle(Pens.Black, x, y, cote, cote)
                x += cote
            Next i
            x = 10
            y += cote
        Next j
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        g.Clear(Color.White)
        Dim x, y, n, i, j, cote As Integer
        n = TextBox1.Text
        cote = TextBox2.Text
        x = 10
        y = 10
        For j = 1 To n
            If j Mod 2 = 0 Then
                For i = 1 To n
                    If i Mod 2 = 1 Then
                        g.FillRectangle(Brushes.Black, x, y, cote, cote)
                    Else
                        g.DrawRectangle(Pens.Black, x, y, cote, cote)
                    End If
                    x += cote
                Next i
                x = 10
                y += cote
            Else
                For i = 1 To n
                    If i Mod 2 = 0 Then
                        g.FillRectangle(Brushes.Black, x, y, cote, cote)
                    Else
                        g.DrawRectangle(Pens.Black, x, y, cote, cote)
                    End If
                    x += cote
                Next i
                x = 10
                y += cote
            End If
        Next j
    End Sub

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        g.Clear(Color.White)
        Dim x, y, n, i, j, k, cote As Integer
        n = TextBox1.Text
        cote = TextBox2.Text
        x = 10
        y = 10
        For j = 1 To n
            If j Mod 2 = 0 Then
                For i = 1 To j
                    If i Mod 2 = 1 Then
                        g.FillRectangle(Brushes.Black, x, y, cote, cote)
                    Else
                        g.DrawRectangle(Pens.Black, x, y, cote, cote)
                    End If
                    x += cote
                Next i
                x = 10
                y += cote
            Else
                For i = 1 To j
                    If i Mod 2 = 0 Then
                        g.FillRectangle(Brushes.Black, x, y, cote, cote)
                    Else
                        g.DrawRectangle(Pens.Black, x, y, cote, cote)
                    End If
                    x += cote
                Next i
                x = 10
                y += cote
            End If
        Next j
    End Sub
End Class
