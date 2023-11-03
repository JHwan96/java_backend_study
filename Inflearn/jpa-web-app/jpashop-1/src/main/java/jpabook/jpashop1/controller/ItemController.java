package jpabook.jpashop1.controller;

import jpabook.jpashop1.domain.item.Book;
import jpabook.jpashop1.domain.item.Item;
import jpabook.jpashop1.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }
    @PostMapping("/items/new")
    public String create(BookForm form){
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setIsbn(form.getIsbn());
        book.setAuthor(form.getAuthor());

        itemService.saveItem(book);
        return "redirect:/items";
    }
    @GetMapping("/items")
    public String list(Model model){
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
        Book findItem = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();
        form.setId(findItem.getId());
        form.setName(findItem.getName());
        form.setPrice(findItem.getPrice());
        form.setStockQuantity(findItem.getStockQuantity());
        form.setIsbn(findItem.getIsbn());
        form.setAuthor(findItem.getAuthor());

        model.addAttribute("form", form);
        return "items/updateItemForm.html";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@PathVariable("itemId") Long itemId, @ModelAttribute("form") BookForm bookForm){
//        Book book = new Book();
//        book.setId(bookForm.getId());
//        book.setName(bookForm.getName());
//        book.setPrice(bookForm.getPrice());
//        book.setStockQuantity(bookForm.getStockQuantity());
//        book.setAuthor(bookForm.getAuthor());
//        book.setIsbn(bookForm.getIsbn());
//        itemService.saveItem(book);

        itemService.updateItem(itemId, bookForm.getName(), bookForm.getPrice(), bookForm.getStockQuantity());
        return "redirect:/items";
    }

}
