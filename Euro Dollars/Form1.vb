Public Class Form1
    Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged
        If Double.TryParse(TextBox1.Text, Nothing) Then
            Dim euros As Double
            euros = TextBox1.Text
            Dim tauxchange As Double = 1.18
            Dim dollars As Double = euros * tauxchange
            TextBox2.Text = dollars
        Else
            TextBox2.Text = ""
        End If
    End Sub

    Private Sub TextBox2_TextChanged(sender As Object, e As EventArgs) Handles TextBox2.TextChanged
        If Double.TryParse(TextBox2.Text, Nothing) Then
            Dim dollars As Double
            dollars = TextBox2.Text
            Dim tauxchange As Double = 1.18
            Dim euros As Double = dollars / tauxchange
            TextBox1.Text = euros
        Else
            TextBox1.Text = ""
        End If
    End Sub
End Class