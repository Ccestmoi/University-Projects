Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        ListBox1.Items.Clear()
        Dim taille, r, s As Integer
        taille = TextBox1.Text
        Dim t(taille) As Integer
        For i = 0 To taille - 1
            r = Rnd() * 100
            s = s + r
            ListBox1.Items.Add(r)
        Next
        TextBox2.Text = s / taille
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Randomize()
    End Sub
End Class
