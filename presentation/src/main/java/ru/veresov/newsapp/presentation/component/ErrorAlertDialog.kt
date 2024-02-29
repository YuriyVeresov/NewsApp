package ru.veresov.newsapp.presentation.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import ru.veresov.newsapp.R

@Composable
fun ErrorAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    errorCode: String,
    errorMessage: String,
    openAlertDialog: Boolean = true,
) {

    var openState by remember { mutableStateOf(openAlertDialog) }

    if (openState) {
        AlertDialog(
            title = {
                Text(text = stringResource(R.string.code, errorCode))
            },
            text = {
                Text(text = errorMessage)
            },
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmation()
                    }
                ) {
                    Text(stringResource(R.string.retry))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismissRequest()
                        openState = false
                    }
                ) {
                    Text(stringResource(R.string.dismiss))
                }
            }
        )
    }
}