package chain_of_responsibility;

// handler
class ResourceCollector {

    String name;
    String resourceType;
    ResourceCollector next;

    ResourceCollector(String name, String resourceType, ResourceCollector next) {
        this.name = name;
        this.resourceType = resourceType;
        this.next = next;
    }

    public void handleRequest(String resourceType) {
        if (this.resourceType.equalsIgnoreCase(resourceType)) {
            System.out.println(name + " is able to deliver the resources.\n");
            return;
        } else {
            System.out.println(name + " is unable to deliver the resources.");
        }

        if (next != null) {
            System.out.println(name + " moves the request to " + next.name + ".");
            next.handleRequest(resourceType);
        } else {
            System.out.println("None is able to deliver the resources.");
        }
    }
}

// requestor
class ConstructionManager {

    String name;
    ResourceCollector resourceCollector;

    ConstructionManager(String name) {
        this.name = name;
    }

    // builds the chain
    public void addContractors(ResourceCollector resourceCollector) {
        this.resourceCollector = resourceCollector;
    }

    public void requestResource(String resourceType) {
        System.out.println(name + " requests for " + resourceType + ".");
        resourceCollector.handleRequest(resourceType);
    }
}

public class ChainOfResponsibility {

    public static void main(String[] args) {
        ConstructionManager castleBuilder = new ConstructionManager("Castle Builders Company");
        castleBuilder.addContractors(new ResourceCollector("Eric's Lumbering Company", "Wood",
                new ResourceCollector("Baldwin's Mining Company", "Stone",
                        new ResourceCollector("Smith's Steel Company", "Steel", null))));

        castleBuilder.requestResource("wood");
        castleBuilder.requestResource("stone");
        castleBuilder.requestResource("steel");
        castleBuilder.requestResource("magic stones");
    }
}

