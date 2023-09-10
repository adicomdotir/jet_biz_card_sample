package ir.adicom.jedbizcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun VideoPostItem() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .zIndex(1f)
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.Black.copy(alpha = 0.2f))
            ) {

            }
            Image(
                painter = painterResource(id = R.drawable.orange_dog),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
            )
            Text(
                text = "11:30", modifier = Modifier
                    .zIndex(2f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .align(
                        Alignment.BottomEnd
                    )
                    .padding(8.dp),
                style = MaterialTheme.typography.caption.copy(Color.White)
            )
        }
    }
}

@Preview
@Composable
fun VideoPostItemPreview() {
    VideoPostItem()
}
