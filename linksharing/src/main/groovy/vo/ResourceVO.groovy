package vo

import topic.Topic
import user.User

class ResourceVO {
    Integer resourceId
    Integer topicId
    String resourceDescription
    String ownerName
    String ownerUsername
    String topicName
    Boolean isLink


    @Override
    public String toString() {
        return "ResourceVO{" +
                "id=" + id +
                ", count=" + count +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                '}';
    }
}
