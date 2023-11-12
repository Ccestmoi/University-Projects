Public Class Form1
    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        TextBox3.Text = ""
    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles TextBox2.TextChanged
        TextBox3.Text = ""
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim hr, min As Integer
        hr = TextBox1.Text
        min = TextBox2.Text
        If min = 59 Then
            If hr = 23 Then
                hr = 0
            Else
                hr = hr + 1
            End If
            min = 0
        Else
            min = min + 1
        End If
        TextBox3.Text = hr & "h" & min
    End Sub
End Class
