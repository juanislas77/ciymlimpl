package com.islas.mockktesting.domain

import com.islas.mockktesting.data.LaunchesItemDTO
import com.islas.mockktesting.domain.models.LaunchDetail
import com.islas.mockktesting.domain.models.LaunchDomain

fun LaunchesItemDTO.toDomain(): LaunchDomain {
    return LaunchDomain(
        id = this.id,
        nameLaunched = this.name,
        dateLaunchedLocal = this.dateLocal,
        logoLaunched = this.links.patch.small?: "",
        article = this.links.article?: "https://www.spacex.com/",
        description = this.details?: "The API service did not provide more information or description related to this launch, for more information open the link to the related article.",
        original = this.links.flickr.original?: emptyList()
    )
}

fun LaunchesItemDTO.toDetail(): LaunchDetail {
    return LaunchDetail(
        id = this.id,
        nameLaunched = this.name,
        dateLaunchedLocal = this.dateLocal,
        logoLaunched = this.links.patch.small,
        article = this.links.article,
        description = this.details,
        media = this.links.reddit.media
    )
}
