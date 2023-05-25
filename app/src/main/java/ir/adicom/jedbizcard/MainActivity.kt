package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOff
import androidx.compose.material.icons.sharp.GppGood
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.ui.theme.JedBizCardTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApp()
        }
    }
}

@Composable
fun LoginApp() {
    JedBizCardTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row {
                    Text(text = "Login Account", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.Person, contentDescription = "person icon")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hello , welcome back to our account !",
                    fontWeight = FontWeight.W400,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(46.dp))
                Surface(
                    modifier = Modifier
                        .height(52.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .border(1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(
                                    Color(0xFF6A00BF),
                                    shape = RoundedCornerShape(
                                        topStart = 12.dp,
                                        bottomStart = 12.dp
                                    )
                                )
                        ) {
                            Text(
                                text = "Email",
                                fontWeight = FontWeight.W600,
                                fontSize = 18.sp,
                                modifier = Modifier.align(alignment = Alignment.Center),
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .align(alignment = Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "Phone Number",
                                fontWeight = FontWeight.W600,
                                fontSize = 18.sp,
                                modifier = Modifier.align(alignment = Alignment.Center)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(46.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Email address", fontWeight = FontWeight.W400, fontSize = 14.sp)
                    })
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Password", fontWeight = FontWeight.W400, fontSize = 14.sp)
                    })
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(alignment = Alignment.End)
                ) {
                    Text(text = "Forgot Password?", fontWeight = FontWeight.W400, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(36.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    color = Color(0xFF190152),
                    shape = RoundedCornerShape(CornerSize(12.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Login",
                            fontWeight = FontWeight.W600,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(36.dp))
                Row {
                    Box(
                        modifier =
                        Modifier
                            .weight(1f)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Divider()
                    }
                    Box {
                        Text(
                            text = "Or sign up with",
                            fontWeight = FontWeight.W400,
                            fontSize = 12.sp,
                        )
                    }
                    Box(
                        modifier =
                        Modifier
                            .weight(1f)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Divider()
                    }
                }
                Spacer(modifier = Modifier.height(36.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_google),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp, 22.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Google",
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                    )
                }
                Spacer(modifier = Modifier.height(36.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0xFF636363)
                        )
                    ) {
                        append("Not register yet? ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.Black
                        )
                    ) {
                        append("Create Account")
                    }
                }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginApp()
}