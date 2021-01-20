package com.svs.markupui.models

import java.io.Serializable

data class BannerAd(
    val banner_id: String?="",
    val banner_image: String?="",
    val banner_status: String?="",
    val banner_title: String?="",
    val created_at: String?="",
    val updated_at: String?=""
):Serializable