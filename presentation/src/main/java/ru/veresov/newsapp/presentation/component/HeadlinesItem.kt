package ru.veresov.newsapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import ru.veresov.newsapp.domain.model.Article
import ru.veresov.newsapp.domain.model.ArticleSource
import ru.veresov.newsapp.presentation.theme.NewsAppTheme

@Composable
fun HeadlinesItem(
    modifier: Modifier = Modifier,
    backgroundShape: Shape = RoundedCornerShape(10),
    article: Article,
) {


    Box(
        modifier = modifier
            .background(Color.Transparent, backgroundShape)
            .clip(backgroundShape)
            .clickable {

            },
        contentAlignment = Alignment.BottomEnd,
        content = {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .background(NewsAppTheme.colorScheme.secondaryBackgroundColor),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
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
                text = article.title ?: "",
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                style = NewsAppTheme.typography.headerLarge,
                color = NewsAppTheme.colorScheme.primaryTextColor
            )
        })

}


@Composable
@Preview
private fun HeadlinesItemPreview() {
    val mockArticle = Article(
        ArticleSource("", ""),
        author = "author",
        content = "content",
        description = "description",
        publishedAt = "publishedAt",
        title = "title",
        url = "url",
        urlToImage = "urlToImage"
    )
    HeadlinesItem(
        modifier = Modifier
            .background(color = Color.Green, shape = RoundedCornerShape(10))
            .fillMaxWidth()
            .height(200.dp), article = mockArticle
    )
}