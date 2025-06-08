// if/else
if (inStock) {
  System.out.println("Available!");
} else {
  System.out.println("Sold out.");
}

// for-loop
for (int i = 1; i <= orders; i++) {
  System.out.println("Processing order #" + i);
}

// while-loop
int retries = 3;
while (retries > 0) {
  System.out.println("Retries left: " + retries);
  retries--;
}