# 🐈 Ching-cheng-hanji 🐁

## Software Architecture
![image](./software.png)
## Infrastructure Architecture
![image](./infra.png)
## Design communications between client and server.

- Protocol => HTTP,TCP
- Communication => JSON file

## API
| URL Mapping | Method | Description |
|-------------|--------|-------------|
| api/events | POST | Create event ใหม่เพิ่มลงฐานข้อมูล |
| api/events | GET | List event ทั้งหมดในฐานข้อมูล |
| api/events/{id} | GET | List event เฉพาะ id ที่ระบุ |
| api/events/{id} | DELETE | ลบ event ตาม id ที่ระบุ |
| api/events/{id} | PUT | อัพเดท event ในฐานข้อมูล |

## ER diagram
![image](./ER_diagram.png)

## Setup dev env
- [GitHub](https://github.com/pataradee/Ching-cheng-hanji.git)
- [Task Board](https://app.clickup.com/36721829/v/li/174788706)
- Tools => 
    - Front-end : VS Code
    - Back-end : IntelliJ
    - Dev ops : Docker
    - Database : MySQL workbench
- Communications => Discord, MS Team
- Port
    - Front-end : 80
    - Back-end : 8080
    - Database : 3306

## Setup dev server


## Wireframes
By [Figma](https://www.figma.com/proto/FFu7WiaBwzUe0KrRhRFeNy/Integrated?page-id=0%3A1&node-id=2%3A2&viewport=241%2C48%2C0.27&scaling=min-zoom&starting-point-node-id=2%3A2)

# 🎫 About Us
งานนี้เป็นส่วนของวิชา INT221 INFORMATION TECHNOLOGY INTEGRATED PROJECT <br/> ภาคเรียนที่ 2 ปีการศึกษา 2564 คณะเทคโนโลยีสารสนเทศ มหาวิทยาลัยเทคโนโลยีพระจอมเกล้าธนบุรี
### 🎫 Team: Ching-cheng-hanji
1. ชื่อ นาย ณัฏฐกรณ์ นามสกุล โชติภัทรจินดา StudentID : ```63130500029```
2. ชื่อ นาย ภัทรดนัย นามสกุล ดีรักษา StudentID : ```63130500090```
3. ชื่อ นางสาว สุวพิชญ์ นามสกุล  โชติสวัสดิ์ StudentID : ```63130500126```
