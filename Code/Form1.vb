Public Class Form1
    Dim tour As Integer = 0
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim cat, code As Integer
        cat = 7362
        code = TextBox1.Text
        If tour = 0 Then
            Label2.Location = New Point(50, 96)
            Label2.Text = "Deuxième essai"
        ElseIf tour = 1 Then
            Label2.Location = New Point(20, 96)
            Label2.Text = "Attention dernier essai !"
        End If

        If code <> cat Then
            TextBox1.Text = "Code erroné, réessayez"
            Timer1.Start()
        Else
            TextBox1.Text = "Bravo !"
            Label2.Location = New Point(35, 96)
            Label2.Text = "Vous avez trouvé"
            Button1.Enabled = False
            TextBox1.ReadOnly = True
        End If

        tour = tour + 1
        Label4.Text = tour

        If tour = 3 And code <> cat Then
            TextBox1.Text = "Accès Interdit"
            TextBox1.ReadOnly = True
            Button1.Enabled = False
        End If
    End Sub

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        TextBox1.Text = ""
        Timer1.Stop()
    End Sub
End Class
