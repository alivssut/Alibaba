package com.example.alibaba.model

class MainHead(
    var mainProducts: MainProducts,
    var sliderCollections: SliderCollections,
    var secondaryProducts: SecondaryProducts,
    var bannerCollection: BannerCollection,
    var sliderCollections2: SliderCollections

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