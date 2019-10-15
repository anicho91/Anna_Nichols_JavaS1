//package com.company;
//
//import java.util.List;
//
//@Component
//public class ItemServiceLayer implements ItemDao{
//
//    ItemDao itemDaoImpl;
//
//    @Autowired
//    public ItemServiceLayer(ItemDao itemDaoImpl) {
//        this.itemDaoImpl = itemDaoImpl;
//    }
//
//    public List<Item> getInStockItems() {
//        List<Item> items = itemDaoImpl.findAll();
//
//        for(Item item : items){
//            if(item.getQuantityInStock>0){
//                return items;
//            }
//        }
//
//    }
//}
