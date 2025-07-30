
function toggleSidebar() {
    document.getElementById('sidebar').classList.toggle('open');
    document.querySelector('.main').classList.toggle('sidebar-open');
}

function showTab(tabId) {
    const contents = document.querySelectorAll('.tab-content');
    const buttons = document.querySelectorAll('.tab-btn');
    contents.forEach(el => el.style.display = 'none');
    buttons.forEach(btn => btn.classList.remove('active'));
    document.getElementById(tabId).style.display = 'block';
    event.target.classList.add('active');
}
