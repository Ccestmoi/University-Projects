Public Class Form1
    Dim essai, n As Integer
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Timer1.Interval = 10
    End Sub

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        n = TextBox1.Text
        n = n + 1
        If n > 99 Then
            n = 0
        End If
        TextBox1.Text = Format(n, "00")
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        ListBox1.Items.Clear()
        essai = 0
        TextBox1.Text = 0
        TextBox2.Text = ""
        Timer1.Enabled = True
        Button2.Enabled = True
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        n = TextBox1.Text
        If n = 50 Then
            TextBox2.Text = "Goal !"
            ListBox1.Items.Add(n)
            Button2.Enabled = False
            Timer1.Enabled = False
        Else
            If essai = 4 Then
                ListBox1.Items.Add(n)
                Button2.Enabled = False
                Timer1.Enabled = False
            Else
                essai += 1
                ListBox1.Items.Add(n)
            End If
        End If
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        Dim t(4) As Integer
        Dim val, vabs, vmin, im As Integer
        For i = 0 To 4
            t(i) = ListBox1.Items(i)
        Next

        vmin = Math.Abs(50 - t(0))

        For j = 1 To 4
            val = 50 - t(j)
            vabs = Math.Abs(val)
            If vabs < vmin Then
                vmin = vabs
                im = j
            End If
        Next
        TextBox2.Text = t(im)
    End Sub
End Class
