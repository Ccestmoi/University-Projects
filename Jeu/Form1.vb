Public Class Form1
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Timer1.Interval = 10
    End Sub

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        Dim n As Integer
        n = TextBox1.Text
        n = n + 1
        If n > 99 Then
            n = 0
        End If
        TextBox1.Text = n
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        ListBox1.Items.Clear()
        Timer1.Enabled = True
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Dim n, essai As Integer
        n = TextBox1.Text
        essai = 0
        If essai < 5 Then
            essai += 1
            ListBox1.Items.Add(n)
        Else
            Timer1.Enabled = False
        End If
    End Sub
End Class
