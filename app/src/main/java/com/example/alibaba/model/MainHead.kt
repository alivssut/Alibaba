package com.example.alibaba.model

class MainHead(
    var mainProducts: MutableList<MainProducts>,
    var sliderCollections: MutableList<SliderCollections>,
    var secondaryProducts: SecondaryProducts,
    var bannerCollection: MutableList<BannerCollection>,
    var sliderCollections2: MutableList<SliderCollections>

)

class MainProducts(
    var icon : String,
    var title : String
)
class SliderCollections(
    var background : String,
    var action : String
)

class SecondaryProducts(
    var icon : String,
    var title : String,
    var subTitle : String,
    var action : String

)

class BannerCollection(
    var title : String,
    var background : String

)