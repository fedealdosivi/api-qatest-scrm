package Forum;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PojoForumMessages
{
    @JsonProperty("Automation")
    private SubForum[] automation;

    @JsonProperty("Testing")
    private SubForum[] testing;

    @JsonProperty("Development")
    private SubForum[] development;

    @JsonProperty("Security")
    private SubForum[] security;

    public SubForum[] getAutomation() {
        return automation;
    }

    public SubForum[] getTesting() {
        return testing;
    }

    public SubForum[] getDevelopment() {
        return development;
    }

    public SubForum[] getSecurity() {
        return security;
    }
}
