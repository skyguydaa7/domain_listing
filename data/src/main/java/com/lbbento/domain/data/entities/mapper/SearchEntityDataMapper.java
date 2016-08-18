package com.lbbento.domain.data.entities.mapper;

import com.lbbento.domain.data.entities.ListingItemEntity;
import com.lbbento.domain.data.entities.SearchEntity;
import com.lbbento.domain.domain.model.ListingItemModel;
import com.lbbento.domain.domain.model.ListingResultModel;
import com.lbbento.domain.domain.model.SearchModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lbbento on 10/08/2016.
 */

@Singleton
public class SearchEntityDataMapper {

    @Inject
    public SearchEntityDataMapper() {}

    public SearchModel transform(SearchEntity searchEntity) {
        SearchModel searchModel = null;
        if (searchEntity != null && searchEntity.getListingResultEntity() != null) {
            List<ListingItemModel> listingItemModelList = new ArrayList<>();
            for (ListingItemEntity lm : searchEntity.getListingResultEntity().getListingItemEntities() ) {
                ListingItemModel listingItemModel = new ListingItemModel();
                listingItemModel.setAdId(lm.getAdId());
                listingItemModel.setAgencyLogoUrl(lm.getAgencyLogoUrl());
                listingItemModel.setBathrooms(lm.getBathrooms());
                listingItemModel.setBedrooms(lm.getBedrooms());
                listingItemModel.setCarspaces(lm.getCarspaces());
                listingItemModel.setDisplayableAddress(lm.getDisplayableAddress());
                listingItemModel.setDisplayPrice(lm.getDisplayPrice());
                listingItemModel.setThumbUrl(lm.getThumbUrl());
                listingItemModel.setSecondThumbUrl(lm.getSecondThumbUrl());
                listingItemModel.setIsElite(lm.isElite());
                listingItemModelList.add(listingItemModel);
            }
            ListingResultModel listingResultModel = new ListingResultModel(listingItemModelList);

            searchModel = new SearchModel(listingResultModel);
        }

        return searchModel;
    }

}
