package com.example.calisthenicsquest.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.calisthenicsquest.R
import com.example.calisthenicsquest.ui.theme.Black
import com.example.calisthenicsquest.ui.theme.BlueGray
import com.example.calisthenicsquest.ui.theme.focusedTextFieldText
import com.example.calisthenicsquest.ui.theme.textFieldContainer
import com.example.calisthenicsquest.ui.theme.unfocusedTextFieldText
import com.example.calisthenicsquest.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            val uiColor = if (isSystemInDarkTheme()) Color.White else Black
            TopSection(uiColor)

            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email",
                            style = MaterialTheme.typography.labelMedium,
                            color = uiColor
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                        unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it},
                    label = {
                        Text(
                            text = "Password",
                            style = MaterialTheme.typography.labelMedium,
                            color = uiColor
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                        unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    onClick = {
                        // TODO: view model call
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(size = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = stringResource(R.string.no_account),
                        style = MaterialTheme.typography.titleMedium,
                        color = uiColor,
                    )

                    TextButton(
                        onClick = { navController.navigate("signup") }
                    ) {
                        Text(
                            text = stringResource(R.string.signup),
                            style = MaterialTheme.typography.titleMedium,
                            color = if (isSystemInDarkTheme()) Color.White else BlueGray,
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun TopSection(uiColor: Color) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(R.drawable.shape),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.46f),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )

        Row(modifier = Modifier.padding(80.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo),
                tint = uiColor,
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor,
                )

                Text(
                    text = stringResource(R.string.app_description),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor,
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor,
        )
    }
}