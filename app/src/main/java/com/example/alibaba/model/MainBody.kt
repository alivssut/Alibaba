package com.example.alibaba.model

class MainBody(
    var actionCards: ActionCard,
    var cardCollectionItem: MutableList<CardCollection>,
    var GridCollectionItem: MutableList<GridCollection>,
    var BannerCollection2Item: MutableList<BannerCollection2>
)

class ActionCard(
    var icon : String,
    var title: String,
    var subTitle: String,
    var ctaTitle: String
)

class CardCollection(
    var title: String,
    var subTitle: String,
    var priceLabel: String,
    var image: String
)

class GridCollection(
    var title : String ,
    var image : String,
    var action : String
)

class BannerCollection2(
    var title : String ,
    var background : String
)