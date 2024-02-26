package ru.veresov.newsapp.presentation.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.veresov.newsapp.domain.api.model.BlockSource
import ru.veresov.newsapp.domain.api.model.Source
import ru.veresov.newsapp.presentation.theme.NewsAppTheme

@Composable
fun NewsBlock(
    modifier: Modifier = Modifier,
    blockNews: BlockSource,
) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .wrapContentHeight()
    ) {
        Text(
            text = blockNews.category,
            textAlign = TextAlign.End,
            style = NewsAppTheme.typography.headerLarge,
            color = NewsAppTheme.colorScheme.primaryTextColor
        )

        LazyRow(modifier.padding(vertical = 8.dp), content = {
            itemsIndexed(blockNews.news) { _, source ->
                NewsItem(source = source) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                    context.startActivity(intent)
                }
            }
        })
    }
}

@Composable
@Preview
private fun NewsBlockPreview() {

    val mockBlockSource = BlockSource(
        "category",
        listOf(
            Source(
                category = "category",
                country = "country",
                description = "description",
                id = "id",
                language = "language",
                name = "name",
                url = "url"
            ),
            Source(
                category = "category",
                country = "country",
                description = "description",
                id = "id",
                language = "language",
                name = "name",
                url = "url"
            ),
            Source(
                category = "category",
                country = "country",
                description = "description",
                id = "id",
                language = "language",
                name = "name",
                url = "url"
            )
        )
    )

    NewsBlock(blockNews = mockBlockSource)
}

