package th.co.cdg.WebService_UI_Homework.DTO;

public class SearchPostDTO {

    private String post_caption;

    public SearchPostDTO(String post_caption) {
        this.post_caption = post_caption;
    }

    public SearchPostDTO() {
    }

    public String getPost_caption() {
        return post_caption;
    }

    public void setPost_caption(String post_caption) {
        this.post_caption = post_caption;
    }
}
