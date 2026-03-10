document.addEventListener("DOMContentLoaded", () => {
  const menuItems = document.querySelectorAll("#sidebar-menu li[data-target]");
  const views = document.querySelectorAll(".view-section");
  const navbarTitle = document.getElementById("navbar-title");

  menuItems.forEach((item) => {
    item.addEventListener("click", () => {
      menuItems.forEach((m) => m.classList.remove("active"));

      item.classList.add("active");

      views.forEach((view) => view.classList.add("hidden"));

      const targetId = item.getAttribute("data-target");
      document.getElementById(targetId).classList.remove("hidden");

      navbarTitle.textContent = item.textContent.trim();
    });
  });
});
