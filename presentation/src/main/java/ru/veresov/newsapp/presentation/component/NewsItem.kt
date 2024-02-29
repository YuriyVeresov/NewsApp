package ru.veresov.newsapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import ru.veresov.newsapp.domain.model.Source
import ru.veresov.newsapp.presentation.theme.NewsAppTheme

@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    source: Source,
    onNewsTap: (String) -> Unit,
) {

    val colors = listOf(
        Color(0xE6D1C4E9),
        Color(0xCCD1C4E9),
        Color(0xB3D1C4E9),
        Color(0x99D1C4E9),
        Color(0x80D1C4E9)
    )

    val cardBackground = Brush.verticalGradient(colors)


    Box(
        modifier = modifier
            .padding(end = 8.dp)
            .size(120.dp, 180.dp)
            .background(cardBackground, RoundedCornerShape(10.dp))
            .clickable {
                onNewsTap.invoke(source.url)
            },
        contentAlignment = Alignment.BottomEnd,
        content = {
            AsyncImage(
                modifier = modifier,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(source.url)
                    .crossfade(true)
                    .crossfade(200)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                onState = {
                    when (it) {
                        AsyncImagePainter.State.Empty -> {

                        }

                        is AsyncImagePainter.State.Error -> {

                        }

                        is AsyncImagePainter.State.Loading -> {

                        }

                        is AsyncImagePainter.State.Success -> {

                        }
                    }
                }
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(8.dp),
                text = source.description,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                style = NewsAppTheme.typography.bodySmallMedium,
                color = NewsAppTheme.colorScheme.primaryTextColor
            )
        })


}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun NewsItemPreview() {
    val mockSource = Source(
        category = "category",
        country = "country",
        description = "description",
        id = "id",
        language = "language",
        name = "name",
        url = "url"
    )
    NewsAppTheme {
        NewsItem(
            source = mockSource
        ) {

        }
    }
}